Web проект “Телефонная книга”
Содержащий страницы:
-авторизацию
-вход в систему (логин/пароль)
-регистрация
-выход из системы
-работа с хранимыми данными
Просмотр всех данных с возможностью фильтрации по имени/фамилии и номеру телефона.Добавление/Редактирование/Удаление хранимых записей
    Система доступна только авторизованным пользователям. Если пользователь не авторизован, при попытке открытия любой страницы его должно редиректить на страницу авторизации. 
На странице авторизации он может ввести логин и пароль для входа в систему или зарегистрироваться. При регистрации указываются поля: ФИО, логин и пароль.
У каждого авторизованного пользователя имеется своя телефонная книга, т.е. каждый пользователь видит только те записи, которые он создал.
Админка для управления пользователями - не требуется.
Проект собирается средствами Maven.Для запуска используется SpringBoot.
Web project "Phonebook"
Containing pages:
-autorisation
-log in (login / password)
-sign in
-sign out
-work with stored data
View all the data with ability to filter by name / surname / phone number. User can  Add / Edit / Delete stored records
    The system is available only to authorized users. If the user is not logged in, when you try to open any page it should redirect to the login page.
On the login page, he can enter a username and password to login or register. When registering specify fields: name, username and password.
Each authorized user has its own phone book, sees only those records that he created.
Admin to manage users - is not required.
The project is run by means of Maven.Run by SpringBoot.