cd /Users/elenalubavina/Desktop/selenium_grid
java -Dwebdriver.gecko.driver=/Users/elenalubavina/.cache/selenium/geckodriver/mac64/0.30.0/geckodriver -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.0.16:4444/grid/register/ -browser "browserName=firefox, maxInstances=3"
