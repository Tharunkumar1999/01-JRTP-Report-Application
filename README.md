-------------------------------
|DB TABLE : CITIZAN_PLANS_INFO|
-------------------------------

CITIZEN_ID          NUMBER      PRIMARY KEY
CITIZEN_NAME        VARCHAR 
GENDER              VARCHAR
PLAN_NAME           VARCHAR
PLAN_STATUS         VARCHAR
PLAN_START_DATE     DATE
PLAN_END_DATE       DATE
BENEFIT_AMOUNT      NUMBER
DENIAL_REASON       VARCHAR
TERMINATED_DATE     DATE
TERMINATION_REASON  VARCHAR


-------------------------
|	JAVA COMPONENTS	   	|
-------------------------

 1)CitizenPlan.java (Entity class)
 
 2)CitizenRepository.java (Interface)
 
 3)CitizenService.java (Interface)
 
 4)CitizenServiceImpl.java (class)
 
 5)PdfGenerator.java (class)
 
 6)ExcelGenerator.java (class)
 
 7)EmailUtils.java (class)
 
 8)ReportController.java (class)
 
 9)SearchRequest.java (class)  // Form binding class or command class //DTO
 
 10)DataLoader.java (runner class)
 
 11)Index.jsp
 
 
 
 ------------------------------
   ReportService.java Interface
 ------------------------------
 
 1)method to get dropdown of planName
 2)method to get dropdown of planStatus
 3)method to d search
 4)method to send excel
 5)method to send pdf
 
 --------------------------------------------------
	In Java if u need to export Excel or PDF
 --------------------------------------------------
 
   Excel --> Apache Poi (Third Party)
   PDF   --> itext pdf/ open pdf/ aspose
   
   
   <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.3</version>
</dependency>



<!-- https://mvnrepository.com/artifact/com.github.librepdf/openpdf -->
<dependency>
    <groupId>com.github.librepdf</groupId>
    <artifactId>openpdf</artifactId>
    <version>2.0.3</version>
</dependency>



-----------------------------------
    SEND MAIL in SpringBoot
-----------------------------------

->Add mail starter dependedncy

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>

->we need to configure SMPT properties

Add below properties in Application.properties

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<Login User to SMTP server>
spring.mail.password=<Login password to SMTP server>  zqpl fonl pvet bsbm
{https://myaccount.google.com/apppasswords?pli=1&rapt=AEjHL4MFHTGc2yhqMYOmKeMsF0NudOO8iWXEqYNGb4tKN8LJ9CXVURWpK9MYkfOqqkq_JjFL50NSs5SIX0O1J6ax6NTwnjAXLscKFtKgfkDu00s9QDrFSsw}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

->Create Email Utility class to send Mail from our Application using JavaMailSender.

Note: In JavaMailSender we have Send() method in which we can pass any of the below 2 parameters

==>Send method can taske SimpleMessage / MimeMessage as parameters

		SimpleMessage: To send a normal Mail
		MimeMessage: To send mail with Attachment.
		
		

 
