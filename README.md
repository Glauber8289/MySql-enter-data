# MySql-enter-data
API: PreparedStatement , executeUpdate ,Statement.RETURN_GENERATED_KEYS ,getGeneratedKeys.Checklist: Inserção simples com preparedStatement  Inserção com recuperação de Id

PreparedStatement 
Olá amigos vamos falar sobre o PreparedStatement desta vez peguei um artigo no link https://lnkd.in/dkHunY2h - li e fiz uma breve explicação comparando com o meu projeto porem meu projeto não e de recuperação de dados mas sim de inserção espero que curtam.

Se ficar curioso(a) e quiser ver o repositório so seguir este link:
https://lnkd.in/dy6BrnBa
#sql #students

Um PreparedStatement é uma instrução SQL pré-compilada. É uma subinterface de Declaração . Os objetos de Instrução preparados têm alguns recursos adicionais úteis do que os objetos de Instrução. Em vez de consultas de codificação permanente, o objeto PreparedStatement fornece um recurso para executar uma consulta ou inserção parametrizada.

Vantagens de PreparedStatement
* Quando PreparedStatement é criado, a consulta SQL é passada como um parâmetro.
* Esta instrução preparada contém uma consulta SQL pré-compilada, portanto, quando PreparedStatement é executado, o DBMS pode apenas executar a consulta em vez de compilá-la primeiro.
* Podemos usar o mesmo PreparedStatement e fornecer parâmetros diferentes no momento da execução.
* Uma vantagem importante de PreparedStatements é que eles evitam ataques de injeção de SQL.

Etapas para usar PreparedStatement:
1. Crie uma conexão com o banco de dados
2. Prepare a declaração em vez de consultas de codificação como :
select * from students where age>10 and name ='João'.

Importante:
No meu projeto fiz uma inserção: portanto criei uma variável chamada:
st = conn.prepareStatement(

Defina marcadores de posição de parâmetro (use pontos de interrogação para marcadores de posição) como:
select * from students where age> ? and name = ?
PreparedStatement myStmt;
myStmt = myCon.prepareStatement(select * from students where age> ? and name = ?);

Como meu projeto foi uma inserção os marcadores de posição de parâmetro foram:
"INSERT INTO seller "
+ "(Name,Email,BirthDate,BaseSalary,DepartmentId) "
+ "VALUES "
+ "(?,?,?,?,?)",
Statement.RETURN_GENERATED_KEYS);

3. Defina os valores dos parâmetros para tipo e posição:
myStmt.setInt(1,10);
myStmt.setString(2,"João");

No meu projeto os valores dos parâmetros para tipo e posição IMPORTANTE CADA INTERROGAÇÃO EQUIVALE A UM VALOR DO PARAMETRO SEQUENCIALMENTE PORTANTO SE TIVER ?,?,?,?,? INTERROGAÇÕES O CORRETO E :1,2,3,4,5 VALOR DE MARCAÇÃO.
st.setString(1, "Joao dos Santos");
st.setString(2, "JoaodosSantos@gmail.com");
st.setDate(3, new java.sql.Date(sdf.parse("17/03/1992").getTime()));
st.setDouble(4, 3000);
st.setInt(5, 4);

4. Execute a consulta :
ResultSet myRs= myStmt.executeQuery();

NO MEU PROJETO REALIZEI A SEGUINTE INSERÇÃO :

int rowsAffected=st.executeUpdate();
if (rowsAffected > 0) {
ResultSet rs= st.getGeneratedKeys();
while (rs.next()) {
int id = rs.getInt(1);
System.out.println("Feito! ID = " + id);

# Perceba que no Console da ID ele traz a seguinte mensagem : 
Feito! ID = 10
Feito! Linhas afetadas 1
![PreparedS](https://github.com/Glauber8289/MySql-enter-data/assets/107453279/35c5bc9c-ee72-48e8-ae09-4655fbeffa86)
# Se observarmos no MySql Workbench:
na coluna ID olharmos os dados são os mesmos que colocamos na IDE provando que a inserção foi realizada com sucesso.!
![PreparedS1](https://github.com/Glauber8289/MySql-enter-data/assets/107453279/ad269687-50c3-4dc9-ac56-12fc2a6c3d85)


