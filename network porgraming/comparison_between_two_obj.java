public class comparison_between_two_obj {

        String name ;
        int age ;
        public comparison_between_two_obj(String name ,int age){
            this.name = name;
            this.age = age;
        }
        public  boolean com(comparison_between_two_obj x,comparison_between_two_obj x1){
           if(x.name == x1.name && x.age == x1.age){
               System.out.println(true);
               return true;
           }
               else {
               System.out.println(false);
                   return false;
           }
        }
        public static void main(String[] args) {
        comparison_between_two_obj obj1 = new comparison_between_two_obj("mohammed",20);
        comparison_between_two_obj obj2 = new comparison_between_two_obj("mohammed",20);
        obj2.com(obj1,obj2);
    }
    }

