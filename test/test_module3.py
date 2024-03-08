import pytest
import allure
from libs.module import Module

@allure.epic("DOCSIS")
class TestDOCSIS_getTURE:
    @allure.feature("DOCSIS_getTURE")
    @allure.title("Verify amo say get TURE")
    @allure.testcase("https://jira.compalbn.com", "NTLSAN-096")
    @allure.severity(allure.severity_level.CRITICAL)
    def test_basic1_get_true_func(self):
        with allure.step("1. verify values1"):
            assert Module.get_true() is True
        with allure.step("2. verify values2"):
            assert Module.get_true() is True

@allure.epic("DOCSIS")
class TestDOCSIS_getFALSE:
    @allure.feature("DOCSIS_getFALSE")
    @allure.title("Verfiy amo say get FALSE")
    @allure.testcase("https://jira.compalbn.com", "NTLSAN-097")
    @allure.severity(allure.severity_level.MINOR)
    def test_basic1_get_false_func(self):
        with allure.step("1. verify values2"):
            assert Module.get_false() is False
