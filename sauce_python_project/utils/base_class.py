from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager

def get_driver():
    chrome_options = Options()
    
    # ✅ Disable password manager and credential service
    prefs = {
        "credentials_enable_service": False,
        "profile.password_manager_enabled": False,
        "profile.default_content_setting_values.notifications": 2,  # Block notifications too
    }
    chrome_options.add_experimental_option("prefs", prefs)

    # ✅ Optional: Use incognito (no saved credentials)
    chrome_options.add_argument("--incognito")

    # ✅ Optional: Use a fresh temporary user profile to avoid saved data
    chrome_options.add_argument("--user-data-dir=/tmp/test-profile")

    # ✅ Optional: Hide infobars that may pop up
    chrome_options.add_argument("--disable-infobars")
    chrome_options.add_argument("--disable-popup-blocking")
    chrome_options.add_argument("--disable-extensions")

    driver = webdriver.Chrome(options=chrome_options)
    driver.maximize_window()
    return driver
