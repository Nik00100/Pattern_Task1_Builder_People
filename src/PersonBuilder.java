public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public boolean doStateCheck() {
        return (name != null) && (surname != null);
    }

    public boolean doArgumentCheck() {
        return (age>=0)&&(age<140);
    }

    public Person build() {
        if (!doStateCheck()) {
            throw new IllegalStateException("Не хватает обязательных полей!");
        }
        if (!doArgumentCheck()) {
            throw new IllegalArgumentException("Недопустимый возраст!");
        }
        if (doStateCheck()){
            if (doArgumentCheck()) {
                Person person = new Person(name, surname, age);
                person.setAddress(address);
                return person;
            } else {
                Person person = new Person(name,surname);
                person.setAddress(address);
                return person;
            }
        }
        return null;
    }
}
