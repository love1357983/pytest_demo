from libs.module import Module

def test2_get_true_func():
    assert Module.get_true() is False

def test2_get_false_func():
    assert Module.get_false() is True
