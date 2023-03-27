# Laboratory Report Management
This is a web application developed using Spring, Thymeleaf, JPA, Maven, and Bootstrap technologies for laboratory report management. The application allows for the following functionalities:

* Report definition: The application allows defining reports by specifying information such as file number, patient name and surname, patient identification number (TC), diagnosis title, diagnosis details, report date, and a single photo in .png/.jpg format.
* Search and sorting: The application provides search and sorting functionalities for patient name/surname, patient identification number, and laboratory technician name/surname. Reports can also be sorted by their dates.
* Update: The application allows for updating existing reports.
* Details view: The application provides a detailed view of all existing reports.
* Deletion: The application allows for deleting existing reports.

# **Running the Application**

To run the application, your computer should have Java 11 or a newer version installed. If you don't have Java you can install it [here](https://www.java.com/en/download/). While you are in the folder where the pom.xml file is located, run the command "mvn compile" to compile the application and "mvn package" to create a jar package. The jar file will be located inside the target folder. When you are in this folder using the cd command on the terminal, run the command "java -jar laboratuvar_raporlama-0.0.1-SNAPSHOT.jar" to run the application. After the application is running, you can access the web page by going to localhost:8080.

***

# Laboratuvar Raporlama
Spring, Thymeleaf, JPA, Maven ve Bootstrap kullanılarak geliştirilmiş bir laboratuvar raporlama uygulaması. Uygulama aşağıdaki özelliklere sahiptir.

* Rapor tanımı: Uygulama, dosya numarası, hasta adı ve soyadı, hasta kimlik numarası (TC), teşhis başlığı, teşhis detayları, rapor tarihi ve tek bir .png/.jpg formatındaki fotoğraf gibi bilgileri belirterek rapor tanımlamaya izin verir.
* Arama ve sıralama: Uygulama, hasta adı/soyadı, hasta kimlik numarası ve laboratuvar teknisyeni adı/soyadı için arama ve sıralama işlevleri sağlar. Raporlar ayrıca tarihlerine göre sıralanabilir.
* Güncelleme: Uygulama, mevcut raporların güncellenmesine izin verir.
* Detay görünümü: Uygulama, tüm mevcut raporların detaylı görünümünü sağlar.
* Silme: Uygulama, mevcut raporların silinmesine izin verir.
    
# **Uygulamanın Çalıştırılması**
Uygulamanın çalıştırılabilmesi için bilgisayarınızda Java 11 veya üzeri bir sürüm yüklü olmalıdır. Eğer Java yüklü değilse [buradan](https://www.java.com/en/download/) yükleyebilirsiniz. Pom.xml dosyasının bulunduğu klasördeyken mvn compile komutu ile uygulama uygulama derlenir, mvn package komutu ile jar paketi oluşturulur. Jar dosyası target klasörünün içinde olacaktır. Terminalde cd komutu ile bu klasöre geldiğinizde java -jar laboratuvar_raporlama-0.0.1-SNAPSHOT.jar komutu ile uygulamayı çalıştırabilirsiniz. Uygulama çalıştıktan sonra localhost:8080 adresine giderek web sayfasına ulaşabilirsiniz.
