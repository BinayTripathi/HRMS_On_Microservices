# Enterprise_HRMS_And_Billing_Using_Microservices
Human Resource Management System and related enterprise operations  using Java Spring boot , Microservices , Hibernate and Restful APIs


<a href="https://info.flagcounter.com/Zp0e"><img src="https://s11.flagcounter.com/count2/Zp0e/bg_FFFFFF/txt_000000/border_CCCCCC/columns_2/maxflags_10/viewers_0/labels_0/pageviews_0/flags_0/percent_0/" alt="Flag Counter" border="0"></a>
    
    

enterprise-billing-system  is the root folder that contains each of the component.

Details of the components:
1.  Eureka naming server - 
2.  Cloud config server - This is used to manage the common configuraition stored in GIT for the microservice infrastructure
3.  employee-management-system - This is a spring boot web application that represents the basic HRMS system in an enterprise. Following concepts 
    are demonstrated in here
	  
    a. Spring dataJPA and hibernate
    
        - H2 in-memory database
	
        - Relationships - One to many
	
          - LazyFetch
	  
        - Entity inheritance
	
        - Enums in Entity
	
        - @JsonManagedReference and @JsonBackReference   
	
	  b. Rest Webservice
	  
		    -	Error Handling
		    
		    -	Response parameter/status
		    
		    -	Swagger     
		    
	  c.  Microservices concepts
	  
		    -	Register to Eureka Naming server
		    
		    -	Pulling configuration from Spring cloud config
		    
		    
		    
    d. lambok
    
        -	getter
	
        -	setter
	
        -	NoArgsContructor
	
        - 	AllArgsConstructor
	
        -	Builder
	
        
  4. Yet - to - come  :   Other components are yet to come that would following the Microservices paradigm . These components will 
      talk to each other using Feign client and Ribbon load balancer as well as an API gateway will intercept the calls before 
      forwarding it over.
      
  
All components have docker files and docker image can be build. Also docker-compose can be used for the orchestration
To run using docker compose :
	1. Copy the docker-compose.yml file present under Enterprise_HRMS_And_Billing_Using_Microservices/enterprise-billing-system/
	2. Open command prompt and cd to folder where the above yml is copied
	3. run the command docker-compose up
	4. Troubleshoot : In case the enterprise-billing-system (container name : tbinay/employee-management-system:0.0.1-SNAPSHOT) is not able to find the Discovery service or Spring Cloud Config Server , we need to stop and restart the container using following steps:
		a. Find all the running docker container using docker container ls
		b. Get the copy the container id of the ems application
		c. Stop the container by running -   docker container stop <container id>
		d. Restart the container by running - docker container start <container id>

 
URLs:

  Naming server:
  
    http://localhost:8761/

  EmployeeManagementSystem
  
    Swagger :  http://localhost:8000/ems/swagger-ui.html
    
        URIs can be see in swagger
	
    H2 Console :  http://localhost:8000/ems/h2-console
    
    
    
    
    

    
  
