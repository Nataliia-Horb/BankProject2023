package com.project.bankproj;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectPackages({"com.project.bankproj.controller", "com.project.bankproj.mapper", "com.project.bankproj.service"})
public class TestSuite {

}
