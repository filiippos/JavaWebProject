/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

/**
 *
 * @author NICK
 */
public class StudentsTable {
    
    public int id;
    public String email;
	public String firstname;
        public String lastname;
        public int numberofanswers;
        public int numberofrightanswers;
	public String quiz1;
        public String quiz2;
        public String quiz3;
        public String course1;
        public String course2;
        public String course3;
        public int age;
        public int preliminary_test;
        

   

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public double score;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    
    public int ranking;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumberofanswers() {
        return numberofanswers;
    }

    public void setNumberofanswers(int numberofanswers) {
        this.numberofanswers = numberofanswers;
    }

    public int getNumberofrightanswers() {
        return numberofrightanswers;
    }

    public void setNumberofrightanswers(int numberofrightanswers) {
        this.numberofrightanswers = numberofrightanswers;
    }

    public String getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(String quiz1) {
        this.quiz1 = quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(String quiz2) {
        this.quiz2 = quiz2;
    }

    public String getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(String quiz3) {
        this.quiz3 = quiz3;
    }
	
     public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public int getPreliminaryTest() {
        return preliminary_test;
    }

   public void setPreliminaryTest(int preliminary_test) {
        this.preliminary_test = preliminary_test;
    }
}
