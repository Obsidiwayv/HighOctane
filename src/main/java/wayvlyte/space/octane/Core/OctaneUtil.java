package wayvlyte.space.octane.Core;

public class OctaneUtil {
    public static Object LoadClass(String ClassName) {
        try {
            Class<?> LoadedClass = Class.forName(ClassName);
            return LoadedClass.getDeclaredConstructor().newInstance();
        } catch (Exception _) {
            System.out.printf("Class %s could not be loaded%n", ClassName);
            return null;
        }
    }
}
