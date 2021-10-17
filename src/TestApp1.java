

public class TestApp1 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.print();
        Parent child = new Child();
        child.print();
    }

    public static class Parent{
        protected String fio;

        public Parent(){
            fio = "анна мария оглы";
        }
        private void print(){
            System.out.println(formatFio());
        }
        protected String formatFio(){
            return fio + "!";
        }
    }
    public static class Child extends Parent{
        StringBuilder result = new StringBuilder();
        public Child(){
            this.fio = "АН'НА-МАРИЯ оглы";
        }
        @Override
        protected String formatFio(){
            char[] fioChars = fio.toCharArray();
            for(int i = 0; i < fioChars.length - 1; i++){
                if (Character.toString(fioChars[i]).equals( "'") ||
                        Character.toString(fioChars[i]).equals( " ") ||
                        Character.toString(fioChars[i]).equals( "-")){
                    fioChars[i + 1] = Character.toUpperCase(fioChars[i + 1]);
                }
                else{
                    fioChars[i + 1] = Character.toLowerCase(fioChars[i + 1]);
                }
                result.append(fioChars[i]);
            }
            result.append(fioChars[fioChars.length - 1]);
            return result.toString();
        }

    }
}
