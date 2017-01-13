package ru.aselit;

public enum TCPThreadStateEnum {
	
	tcptNone, tcptWaitResponse, tcptAuthorize, tcptCommand, tcptReceive, tcptSend, tcptDone, tcptError;
	
	public static String asString(TCPThreadStateEnum state) {
		
		switch (state) {
		case tcptWaitResponse:	return "Waiting for a response";
		case tcptAuthorize:		return "Authorize";
		case tcptCommand:		return "Command";
		case tcptReceive:		return "Receive";
		case tcptSend:			return "Send";
		case tcptDone:			return "Done";
		case tcptError:			return "Error";
		default:				return "Unknown";
		}
	}
}
