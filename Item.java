public class Item {

        private String name;
        private String description;
    
        public Item(String name, String description) {
            this.name = name;
            this.description = description;
        }
    
        // Getters for name and description
        public String getName() {
            return name;
        }
    
        public String getDescription() {
            return description;
        }
}
