package com.easydroid.romctrl;

import java.io.PrintWriter;

public class Utils {

	/**
	 * @param cmd
	 *            要运行的命令
	 * @return 返回false表示无法获取ROOT权限
	 */
	public static boolean runCmd(String cmd) {
		try {
			boolean root = true;
			Process process = null;
			if (root) {
				process = Runtime.getRuntime().exec("su");
				PrintWriter pw = new PrintWriter(process.getOutputStream());
				pw.println(cmd);
				pw.flush();
				pw.close();
				process.waitFor();
			} else {
				process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (process != null) {
				return process.exitValue() != 0 ? false : true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
