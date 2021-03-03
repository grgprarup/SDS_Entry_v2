package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List<Member> importMembers(File inputFile) throws Exception {

		/*
		 * Implement the missing logic
		 */
		List<Member> members = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
			String line = br.readLine();

			while (line != null) {
				members.add(new Member(line.substring(0, 12).trim(), line.substring(12, 37).trim(),
						line.substring(37, 62).trim(), line.substring(62, 92).trim(), line.substring(92, 112).trim(),
						line.substring(112, 116).trim(), line.substring(116, 121).trim()));
				line = br.readLine();
			}
		}

		return members;
	}

}
