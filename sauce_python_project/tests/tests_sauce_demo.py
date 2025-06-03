import pytest
from utils.base_class import get_driver
from pages.sauce_demo_page import sauce_demo_page

@pytest.fixture
def setup():
    driver = get_driver()
    driver.get("https://www.saucedemo.com/")
    yield driver
    driver.quit()

def tests_sauce_demo_case(setup):
    page = sauce_demo_page(setup)

    # Step 1: Login
    page.login()
    # Step 2: Verify SWAG LABS logo
    assert page.is_logo_present(), "SWAG LABS logo not found."

    # Step 3: Add an item to the cart
    page.add_item_to_cart()

    # Step 4: Verify item in cart
    assert page.go_to_cart_and_verify(), "Item was not found in the cart."

    # Step 5: Logout
    page.logout()
