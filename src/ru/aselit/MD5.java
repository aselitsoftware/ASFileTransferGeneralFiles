package ru.aselit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5 {

	public static String getFileHash(File file) {
		
		InputStream stream = null;
		byte[] buffer = null;
		String result = "";
		
		/*
		try {
			source = data.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			source = data.getBytes();
		}
		*/
		
		try {
			
			stream = new FileInputStream(file);
			buffer = new byte[new Long(file.length()).intValue()];
			stream.read(buffer);
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(buffer);
			byte t[] = md.digest();
			for (byte b: t)
				result += String.format("%02x", b & 0xff);
		
		} catch (FileNotFoundException e1) {
		
		} catch (IOException e) {
		
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		} finally {
		
			try {
				if (null != stream)
					stream.close();
			} catch (IOException e) {
			}
		}
		
		return result.toUpperCase();
	}
}
