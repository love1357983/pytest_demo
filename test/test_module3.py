import pytest
import allure
from libs.module import Module

@allure.epic("DOCSIS")
class TestDOCSIS_getTURE:
    @allure.feature("DOCSIS_getTURE")
    @allure.title("amo say get TURE")
    @allure.testcase("NTLSAN-096", "TC amo say get TURE")
    @allure.severity(allure.severity_level.CRITICAL)
    def test_basic1_get_true_func():
        with allure.step("1. verify values1"):
            assert Module.get_true() is False

@allure.epic("DOCSIS")
class TestDOCSIS_getFALSE:
@allure.feature("DOCSIS_getFALSE")
@allure.title("amo say get FALSE")
@allure.testcase("NTLSAN-097", "TC amo say get FALSE")
@allure.severity(allure.severity_level.MINOR)
def test_basic1_get_false_func():
    with allure.step("1. verify values2"):
        assert Module.get_false() is True
