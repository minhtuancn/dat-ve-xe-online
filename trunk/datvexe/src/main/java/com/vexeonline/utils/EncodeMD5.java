package com.vexeonline.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class EncodeMD5 {
	private static final Logger logger = Logger.getLogger(EncodeMD5.class);

	/**
	 * encode md5 for input string
	 * 
	 * @param input
	 * @return string after encode md5
	 * @throws RuntimeException
	 *             when error NoSuchAlgorithmException : if no Provider supports
	 *             a MessageDigestSpi implementation for the specified
	 *             algorithm.
	 */
	public static String encodeMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			// Now we need to zero pad it if you actually want the full 32
			// chars.
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			logger.error("Error encodeMD5!", e);
			throw new RuntimeException(e);
		}
	}
}
