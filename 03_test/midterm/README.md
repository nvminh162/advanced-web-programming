# @nvminh162 setup

## I. Dependencies:
+ Specifications: web profile
+ Implementations: Hibernate

## II. Add dependencies (pom.xml)
+ https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api
+ https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl
+ https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client
+ https://mvnrepository.com/artifact/org.projectlombok/lombok
```xml
<dependencies>
    <!-- https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api -->
    <dependency>
        <groupId>jakarta.servlet.jsp.jstl</groupId>
        <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
        <version>3.0.2</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl -->
    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jakarta.servlet.jsp.jstl</artifactId>
        <version>3.0.1</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>3.5.6</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.42</version>
    </dependency>
    <dependency>
        <groupId>jakarta.servlet</groupId>
        <artifactId>jakarta.servlet-api</artifactId>
        <version>6.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>${junit.version}</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>${junit.version}</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## III. Create context.xml
webapp -> META-INF/context.xml
```xml
<Context>
    <Resource
            name="jdbc/www_midterm_01"
            auth="Container"
            type="javax.sql.DataSource"
            maxTotal="20"
            maxIdle="10"
            maxWaitMillis="10000"
            driverClassName="org.mariadb.jdbc.Driver"
            url="jdbc:mariadb://localhost:3307/www_midterm_01"
            username="root"
            password="root"/>
</Context>
```

## IV. Config web.xml
webapp -> WEB-INF/web.xml
```xml
<resource-ref>
    <res-ref-name>jdbc/www_midterm_01</res-ref-name>
    <res-type>javax.sql.DataSource</res-type>
    <res-auth>Container</res-auth>
</resource-ref>

<welcome-file-list>
    <welcome-file>departments</welcome-file>    
</welcome-file-list>
```

## V. Config hibernate
src/main/resources/META-INF/persistence.xml
```xml
<non-jta-data-source>java:comp/env/jdbc/www_midterm_01</non-jta-data-source>

<properties>
    <property name="hibernate.dialect" value="org.hibernate.dialect.MariaDBDialect"/>
    <property name="hibernate.hbm2ddl.auto" value="update"/>
    <property name="hibernate.show_sql" value="true"/>
    <property name="hibernate.format_sql" value="true"/>
</properties>
```
## VI. Create JPA
- util -> DBUtil
- Application.java
```java
@WebListener
public class Application implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JpaUtil.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JpaUtil.destroy();
    }
}
```

## Good my exam @nvminh162! peace