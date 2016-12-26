package ru.aselit;

public enum FileConnectCommandEnum {

	fccNone(0), fccAuthorize(1), fccFileInfo(2), fccUploadStart(3), fccUpload(4), fccDownloadStart(5), fccDownload(6);
	
	private final int value;
	
	private FileConnectCommandEnum(int value) {
		
		this.value = value;
	}
	
	public int toInt() {
		
		return value;
	}
	
	public static FileConnectCommandEnum fromInt(int value) {
		
		int i;
		
		FileConnectCommandEnum []v = values();
		
		for (i = 0; i < v.length; i++)
			if (value == v[i].ordinal())
				return v[i];
		return fccNone;
	}
}
