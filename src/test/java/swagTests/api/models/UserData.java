package swagTests.api.models;

public class UserData {
        private String name;
        private String job;
        private String firstName;
        private String lastName;
        private String zip;

        public UserData() {
        }

        public UserData(String firstName, String lastName, String zip) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.zip = zip;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public void setZip(String zip) {
                this.zip = zip;
        }

        public String getFirstName() {
                return firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public String getZip() {
                return zip;
        }
}