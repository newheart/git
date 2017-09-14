package fileDecrypt;

import java.util.Scanner;

public class DecryptMain {

	public static void main(String[] args) {
		System.out.print("请输入文件路径：");
		Scanner scan = new Scanner(System.in);
		System.out.println();
		String filePath = scan.nextLine();
		System.out.println("加密文件为：" + filePath);

		System.out.print("请输入文件秘钥：");
		String key = scan.nextLine();
		byte[] bkey;
		try {
			bkey = key.getBytes("UTF-8");
			String mode = "AES/ECB/PKCS5Padding";
			byte[] fileBytes = FileUtil.File2byte(filePath);
			
			byte[] original_data = AESUtils.AESDecrypt(fileBytes, bkey, mode);
			System.out.print("请输入解密后文件名：");
			String DecryptFileName = scan.nextLine();
			System.out.print("请输入解密后文件保存路径：");
			String outpath = scan.nextLine();
			
			FileUtil.byte2File(original_data, outpath, DecryptFileName);
			System.out.println("文件加密成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
