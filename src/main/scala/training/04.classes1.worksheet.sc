import scala.beans.BeanProperty

class Counter {
  private var i = 0
  def increment() = i+=1
  def increment(j:Int) = i+=j
  def current = i
}

val counter = new Counter

counter.increment()
println(counter.current)

class Person {
  var age = 0
}
val person = new Person
person.age = 9
println(person.age)
/*
public class Person {
  private int age;
  public Person(int a) {
    this.age = a;
  }
  public int setAge(int value) {
    this.age = value;
  }
  public int getAge() {
    return this.age;
  }
}
 */

class Person2 {
  private var _age = 0

  def age = _age
  def age_=(v: Int) = _age = v
}

val p = new Person2
p.age
p.age = 5

class PersonImmutable(ageP:Int) {
  val age = ageP

  def getAge = age
  val age2 = ageP
}

/*
class PersonUmmutable {
public static final Integer age;
public static final Integer age2;
 public PersonUmmutable(Integer ageP){
  this.age = ageP;
  this.age2 = ageP;

 }
 }
 */

val iPerson = new PersonImmutable(23)
iPerson.age

class PersonNS(val name:String,val surname:String) {

  def this(pname:String) {
    this(pname,"default")
  }
}

val pns = new PersonNS("anil","halil")
val pns2 = new PersonNS("anil")
//pns.pname = "dasdsad"
pns.name
pns.surname

class JavaBean(@BeanProperty var a:Int) {
}

val jb = new JavaBean(2)
