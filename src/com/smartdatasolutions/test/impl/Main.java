package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter() {
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter() {
		return new MemberImporterImpl();
	}

	@Override
	protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {

		// Since set doesn't take duplicate entries, LinkedHashSet is used. The concept
		// of equals and hashcode is used here

		return new ArrayList<>(new LinkedHashSet<>(membersFromFile));
	}

	@Override
	protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {

		// Grouping the List of members with respect to states using java 8
		// Source: https://www.baeldung.com/java-groupingby-collector

		return validMembers.stream().collect(Collectors.groupingBy(Member::getState));
	}

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.convert(new File("../SDS_Entry_v2/Members.txt"),
				"../SDS_Entry_v2/output", "outputFile.csv");
	}

}
