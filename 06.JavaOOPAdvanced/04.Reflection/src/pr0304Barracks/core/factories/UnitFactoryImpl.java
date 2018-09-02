package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";


	@Override
	public Object createUnit(String unitType)  {

		Unit unit = null;
		try	{
			Class<?> unitsClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> unitsClassDeclaredConstructor = unitsClass.getDeclaredConstructor();
			unitsClassDeclaredConstructor.setAccessible(true);
			unit = (Unit) unitsClassDeclaredConstructor.newInstance();

		} catch (ClassNotFoundException |
				NoSuchMethodException |
				IllegalAccessException |
				InvocationTargetException |
				InstantiationException e) {
			e.printStackTrace();
		}
		return unit;
	}
}
