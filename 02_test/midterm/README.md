# @nvminh162 setup

## I. Dependencies:

- Specifications: web profile
- Implementations: Hibernate

## II. Add dependencies (pom.xml)

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
            <groupId>jakarta.platform</groupId>
            <artifactId>jakarta.jakartaee-web-api</artifactId>
            <version>11.0.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.0.4.Final</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-runtime</artifactId>
            <version>4.0.5</version>
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

## III. Config web.xml

webapp -> WEB-INF/web.xml

```xml
    <welcome-file-list>
        <welcome-file>hello-servlet</welcome-file>
    </welcome-file-list>
```

## IV. Config hibernate

src/main/resources/META-INF/persistence.xml

```xml
    <persistence-unit name="nguyenvanminh_mariadb">
        <!-- <class>com.nvminh162.nguyenvanminh.model.LoaiThuoc</class >-->
        <!-- <class>com.nvminh162.nguyenvanminh.model.Thuoc</class >-->
        <properties>
            <!-- driver | driverClassName="org.mariadb.jdbc.Driver" -->
            <property name="jakarta.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver"/>
            <!-- url | url="jdbc:mariadb://localhost:3307/www_midterm_01" -->
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mariadb://localhost:3307/www_midterm_04"/>
            <!-- user | username="root" -->
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <!-- password | password="root" -->
            <property name="jakarta.persistence.jdbc.password" value="root"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.MariaDBDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
```

## V. Create JPA

- util -> JPAUtil.java
```java
    public class JPAUtil {
        @Getter
        private static EntityManagerFactory emf;

        public static void init() {
            if (emf == null) emf = Persistence.createEntityManagerFactory("nguyenvanminh_mariadb");
        }

        public static void close() {
            if (emf != null && emf.isOpen()) emf.close();
        }
    }
```

- JPAListener.java

```java
    @WebListener
    public class JPAListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) { JPAUtil.init(); }

        @Override
        public void contextDestroyed(ServletContextEvent sce) { JPAUtil.close(); }
    }
```

## Good my exam @nvminh162 peace <3 hẹ hẹ...
