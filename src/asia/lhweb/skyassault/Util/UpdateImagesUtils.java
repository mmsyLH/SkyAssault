package asia.lhweb.skyassault.Util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 批量修改文件名
 * @author :罗汉
 * @date : 2024/1/30
 */
public class UpdateImagesUtils {
    public static void main(String[] args) {
        // 指定目录路径
        String directoryPath = "F:\\JavaWorksparce\\SkyAssault\\images\\leida";

        // 创建一个 File 对象表示目录
        File directory = new File(directoryPath);

        // 检查目录是否存在
        if (directory.exists() && directory.isDirectory()) {
            // 获取目录下所有文件
            File[] files = directory.listFiles();

            // 遍历文件数组并修改文件名
            if (files != null) {
                for (File file : files) {
                    String oldFilePath = file.getAbsolutePath();
                    String newFileName = extractFileName(file.getName()) + ".jpg";

                    // 构建新的 File 对象
                    File newFile = new File(directory, newFileName);

                    // 重命名文件
                    if (file.renameTo(newFile)) {
                        System.out.println("文件重命名成功：" + oldFilePath + " -> " + newFileName);
                    } else {
                        System.out.println("文件重命名失败：" + oldFilePath);
                    }
                }
            } else {
                System.out.println("目录为空或无法访问。");
            }
        } else {
            System.out.println("指定目录不存在或不是一个有效的目录。");
        }
    }

    /**
     * 提取文件名中的数字部分
     */
    private static String extractFileName(String fileName) {
        // 使用正则表达式提取文件名中的数字部分
        String[] parts = fileName.split("_|\\.");
        return parts[parts.length - 2];
    }
}
