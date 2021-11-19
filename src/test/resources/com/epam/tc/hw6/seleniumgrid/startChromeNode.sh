cd /Users/elenalubavina/Desktop/selenium_grid
java -Dwebdriver.chrome.driver=/Users/elenalubavina/.cache/selenium/chromedriver/mac64/95.0.4638.69/chromedriver -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.16:4444/grid/register/ -browser "browserName=chrome, maxInstances=3"
