# A-springcloud-project
Test for all popular 3rd party springcloud module  
I hope this project can improve our ability   
## my project environment：  
###    MacOS-10.15  
###    springcloud-2.2.2 or you can choose 2.2.x~2.3.x  
###    eureka-2.2.1  
###    hystrix-2.2.1  
###    gateway-2.2.1  
###    springcloud-alibaba-2.1.0  
###    nginx-1.18  
###    nacos-1.32  
###    sentinel-1.8.0 
###    seata-1.0
------------------------------------  
Do not use MySQL8.x,this problem can make seata error because seata used MySQL connector/J 5.x.For solve this problem，you need download MySQL connector/J 8.x and modify “file.conf”.driver-class-name = "com.mysql.cj.jdbc.Driver"
