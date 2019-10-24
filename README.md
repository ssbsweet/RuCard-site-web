# RuCard site autotests

Набор тестов для автоматизации проверки чек листа по RuCard
=============================================================

Сайт по-умолчанию: 
http://rucard.srv.lan/

Сборка в Maven
--------------

tetsng
------

>Тестовый фреймворк.

>Для запуска тестов необходимо в файле *\src\test\resources\testng.xml*  
>закоментить/раскоментить необходимые файлы тестов;  
>запустить Test-suite через меню ПКМ файла testng.xml или
>двойным кликом по test в меню сборщика Maven;  
>>Документация: 
>>https://testng.org/doc/documentation-main.html

selenium-java
-------------

allure-testng
-------------

>После прогона тестов, генерирует папку allure-result с результатами тестов;

>Для расшифровки результатов, необходимо скачать последнюю версию allure:
>http://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/
>распакуйте архив и добавьте путь до allure.bat в переменные среды (PATH);  
>убедитесь в установке allue командой в cmd "allure --version";  
>в cmd пропишие "allure serve ПУТЬ ДО ПАПКИ allure-result";  
>>Документация: 
>>https://docs.qameta.io/allure/

webdrivermanager
----------------

>Сам проверяет текущую версию драйвера и подбирает файл для запуска драйвера.

>В BasePage раскоментить/дописать используемый драйвер;
>по-умолчанию стоит Chrome Webdriver; WebDriverManager.chromedriver().setup();  
>в тесте раскоментить/дописать создание драйвера;   
>пример: driver = new ChromeDriver();  
>>Документация: 
>>https://github.com/bonigarcia/webdrivermanager
