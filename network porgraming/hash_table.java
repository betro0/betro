import java.util.Hashtable;
   class hash_table {
        private String author;
        private String tsbn;
        private String titel;
        public hash_table(String author, String tsbn, String title) {
            this.setAuthor("author");
            this.setTsbn(" isbn");
              this.titel=title;        }
        public void setAuthor(String author) {
            this.author = author;
        }
        public void setTsbn(String tsbn) {
            this.tsbn = tsbn;
        }
        public void setTitel(String titel) {
            this.titel = titel;
        }
        public String getTitel() {
            return titel;
        }
        public String getTsbn() {
            return tsbn;
        }
        public String getAuthor() {
            return author;
        }
    //   @Override
       //  public String toString() {
       //    return "" + "author='" + author + '\'' + ", tsbn='" + tsbn + '\'' + ", titel='" + titel + '\'' ;
       //}
   }
       class catague {
            public catague() {
            }
           // private Hashtable thebook;
            Hashtable thebook = new Hashtable();
            public void addbook(hash_table ahash_table) {
                this.thebook.put(ahash_table.getTsbn(), ahash_table);

                 }
            public boolean include(hash_table ahash_table) {

                return thebook.containsKey(ahash_table.getTsbn());
            }
        }
     class book_test {
        public static void  main(String[] args) {
            catague the_catague = new catague();
            hash_table ahashTable = new hash_table("mohammed", "09-08-07", "title");
            the_catague.addbook(ahashTable);
            ahashTable = new hash_table("ali", "11-12-12", "the relm");
            the_catague.include(ahashTable);
            if (the_catague.include(ahashTable)) {
                System.out.println("book found" + ahashTable);
            } else {
                System.out.println("book not found " + ahashTable);
            }
        }
}








