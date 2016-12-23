package ru.aselit;

public enum FileConnectCommandEnum {

	fccNone, fccAuthorize, fccFileInfo, fccUploadStart, fccUpload, fccDownloadStart, fccDownload;
	
	public static FileConnectCommandEnum fromInt(int value) {
		
		int i;
		
		FileConnectCommandEnum []v = values();
		
		for (i = 0; i < v.length; i++)
			if (value == v[i].ordinal())
				return v[i];
		return fccNone;
	}
}
