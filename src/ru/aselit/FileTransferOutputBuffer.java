package ru.aselit;

import java.io.IOException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileTransferOutputBuffer {

	private static final Logger log = LogManager.getLogger(FileTransferOutputBuffer.class);
	
	/**
	 * Send block of data to the server. 
	 * @param block
	 */
	public static void sendBlock(Socket socket, String block) {
		
		if ((null == socket) || (block.length() == 0))
			return;
		
		byte[] data = new byte[Integer.BYTES + block.length()];
		data[0] = (byte) (block.length() & 0xFF);
		data[1] = (byte) (block.length() & 0xFF00);
		data[2] = (byte) (block.length() & 0xFF0000);
		data[3] = (byte) (block.length() & 0xFF000000);
		System.arraycopy(block.getBytes(), 0, data, Integer.BYTES, block.length());
		
		try {
			
			socket.getOutputStream().write(data);
		
		} catch (IOException ex) {
			
			if (log.isDebugEnabled())
				log.debug(ex);
		}
	}
	
}
