package controller;

import java.io.*;
import java.nio.file.*;
import model.Magasin;

public class DeleteMagasin {
	
	public int status = 0;
	
	public DeleteMagasin(Magasin m) {
		try {
			File folder = new File("src/data/m_" + m.getNom());
			if(folder.exists()) {
				File data = new File(folder.getPath() + "/data.txt");
				Files.delete(data.toPath());
				Files.delete(folder.toPath());
				status = 1;
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
