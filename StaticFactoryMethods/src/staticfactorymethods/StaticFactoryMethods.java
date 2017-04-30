package staticfactorymethods;


public class StaticFactoryMethods {

    
    public static void main(String[] args) {
        
        Services.registerDefaultProvider(DEFAULT_PROVIDER);
        Services.registerProvider("comp",   COMP_PROVIDER);
        Services.registerProvider("armed", ARMED_PROVIDER);
        
        Service s1 = Services.newInstance();
        Service s2 = Services.newInstance("comp");
        Service s3 = Services.newInstance("armed");
        
        System.out.printf("%s, %s, %s%n", s1, s2, s3);
        
    }
    
    private static Provider DEFAULT_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service(){
                @Override
                public String toString() {
                    return "DEFAULT_SERIVCE";
                }
                
            };
        }
    };
    
    private static Provider COMP_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service(){
                @Override
                public String toString() {
                    return "COMP_PROVIDER";
                }
                
            };
        }
    };
    
    private static Provider ARMED_PROVIDER = new Provider() {
        @Override
        public Service newService() {
            return new Service(){
                @Override
                public String toString() {
                    return "ARMED_PROVIDER";
                }
                
            };
        }
    };
    
}
