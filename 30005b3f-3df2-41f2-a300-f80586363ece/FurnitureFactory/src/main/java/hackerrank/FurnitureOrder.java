package hackerrank;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	private HashMap<Furniture, Integer> orderItemsMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
    	orderItemsMap = new HashMap<>();
        // TODO: Complete the constructor
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
    	orderItemsMap.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return orderItemsMap;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	float totalCost = 0.0f;
    	
    	Set<Map.Entry<Furniture, Integer>> entrySet = orderItemsMap.entrySet();
    	Iterator<Entry<Furniture, Integer>> iterator = entrySet.iterator();
    	
    	while(iterator.hasNext()) {
    		Entry<Furniture, Integer> entry = iterator.next();
    		totalCost = totalCost + (entry.getKey().cost() * entry.getValue());
    	}
    	
    	if(orderItemsMap.size() == 0) {
    		return -1.0f;
    	}else {
    		return totalCost;
    	}
    }

    public int getTypeCount(Furniture type) {
       if(orderItemsMap.get(type) == null) {
    	   return 0;
       }
       return orderItemsMap.get(type);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	
    	float totalCost = 0.0f;
    	
    	Integer typeCount = orderItemsMap.get(type);
    	if(typeCount != null) {
    		totalCost = totalCost + typeCount * type.cost();
    		return totalCost;
    	}
    	
        return totalCost;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
    	
    	if(orderItemsMap.size() == 0) {
     	   return -1;
        }else {
        	Collection<Integer> counts = orderItemsMap.values();
        	Iterator<Integer> itr = counts.iterator();
        	int totalCount = 0;
        	while(itr.hasNext()) {
        		totalCount += itr.next();
        	}
        	return totalCount;
        }
    }
}