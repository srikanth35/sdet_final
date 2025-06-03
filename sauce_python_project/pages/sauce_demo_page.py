from selenium.webdriver.common.by import By

class sauce_demo_page:
    def __init__(self, driver):
        self.driver = driver

    def login(self, username="standard_user", password="secret_sauce"):
        self.driver.find_element(By.ID, "user-name").send_keys(username)
        self.driver.find_element(By.ID, "password").send_keys(password)
        self.driver.find_element(By.ID, "login-button").click()

    def is_logo_present(self):
        return "Swag Labs" in self.driver.title or self.driver.find_element(By.CLASS_NAME, "app_logo").is_displayed()

    def add_item_to_cart(self):
        self.driver.find_element(By.CLASS_NAME, "btn_inventory").click()

    def go_to_cart_and_verify(self):
        self.driver.find_element(By.CLASS_NAME, "shopping_cart_link").click()
        return len(self.driver.find_elements(By.CLASS_NAME, "cart_item")) > 0

    def logout(self):
        self.driver.find_element(By.ID, "react-burger-menu-btn").click()
        self.driver.implicitly_wait(2)
        self.driver.find_element(By.ID, "logout_sidebar_link").click()
