package asia.lhweb.skyassault.Util;

import javax.sound.sampled.*;
import java.io.*;

/**
 * 音乐线程
 *
 * @author 罗汉
 * @date 2024/02/02
 */
public class MusicThread extends Thread {

    // 音频文件名
    private final String videos;
    private AudioFormat audioFormat;
    private byte[] samples;
    // 播放/停止标志
    private boolean isStop = false;
    // 循环播放标志
    private boolean inLoop = false;
    // 结束播放标志
    private boolean toEnd = false;


    /**
     * 音乐线程
     *
     * @param filename 文件名
     * @param isStop   是停止
     * @param inLoop   在循环
     */
    public MusicThread(String filename, boolean isStop, boolean inLoop) {
        // 初始化filename
        this.videos = filename;
        this.isStop = isStop;
        this.inLoop = inLoop;
        reverseMusic();
    }

    /**
     * 改变音乐
     */
    public void reverseMusic() {
        try {
            // 定义一个AudioInputStream用于接收输入的音频数据，使用AudioSystem来获取音频的音频输入流
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(videos));
            // 用AudioFormat来获取AudioInputStream的格式
            audioFormat = stream.getFormat();
            samples = getSamples(stream);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到样品
     *
     * @param stream 流
     * @return {@link byte[]}
     */
    public byte[] getSamples(AudioInputStream stream) {
        int size = (int) (stream.getFrameLength() * audioFormat.getFrameSize());
        byte[] samples = new byte[size];
        DataInputStream dataInputStream = new DataInputStream(stream);
        try {
            dataInputStream.readFully(samples);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return samples;
    }

    /**
     * 播放
     *
     * @param source 源
     */
    public void play(InputStream source) {
        int size = (int) (audioFormat.getFrameSize() * audioFormat.getSampleRate());
        byte[] buffer = new byte[size];
        // 源数据行SoureDataLine是可以写入数据的数据行
        SourceDataLine dataLine = null;
        // 获取受数据行支持的音频格式DataLine.info
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            dataLine = (SourceDataLine) AudioSystem.getLine(info);
            dataLine.open(audioFormat, size);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        assert dataLine != null;
        dataLine.start();
        try {
            // 暂停
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                // 结束
                if (toEnd) {
                    break;
                }
                // 暂停
                if (isStop) {
                    //设置个时间用来确保在关闭数据行之前，所有的音频数据都已经被播放出去
                    // try {
                    //     Thread.sleep(100);
                    // } catch (InterruptedException e) {
                    //     e.printStackTrace();
                    // }
                    break;
                }
                // 从音频流读取指定的最大数量的数据字节，并将其放入缓冲区中
                numBytesRead =
                        source.read(buffer, 0, buffer.length);
                // 通过此源数据行将数据写入混频器
                if (numBytesRead != -1) {
                    dataLine.write(buffer, 0, numBytesRead);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /**
         * drain() 方法是用于等待数据行中的所有音频数据被播放完成。
         * 在调用 drain() 之前，确保已经完成向数据行写入所有的音频数据。
         * 调用 drain() 会导致程序阻塞，直到数据行中的所有数据被播放完毕。这是为了确保在关闭数据行之前，所有的音频数据都已经被播放出去。
         */
        if(!inLoop){
            dataLine.drain();
        }
        /**
         * close() 方法用于关闭音频数据行。调用 close() 之后，数据行将不再接受新的音频数据，且任何未播放的音频数据都会被丢弃。关闭数据行是在音频播放结束后的清理步骤。
         */
        dataLine.close();

    }

    /**
     * 设置音效打开/关闭
     */
    public void setStop(boolean isStop) {
        this.isStop = isStop;
    }

    /**
     * 设置循环播放
     */
    public void setInLoop(boolean inLoop) {
        this.inLoop = inLoop;
    }

    /**
     * 结束播放
     */
    public void setToEnd(boolean toEnd) {
        this.toEnd = toEnd;
    }

    /**
     * 控制音频循环播放
     */
    @Override
    public void run() {
        if (inLoop) {
            while (inLoop) {
                InputStream stream = new ByteArrayInputStream(samples);
                play(stream);
            }
        } else {
            InputStream stream = new ByteArrayInputStream(samples);
            play(stream);
        }
        Thread.currentThread().interrupt();// 中断线程
    }

}
