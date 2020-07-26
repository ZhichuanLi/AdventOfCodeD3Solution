/**
 * 
 */
package com.zhichuan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lizhichuan
 *
 */
public class CrossedWires {
	
    /**
    * find all cross point and return the shortest Manhattan distance
    *
    * @param  wirePathOne   input of first wire
    * @param  wirePathTwo   input of second wire
    * @return Manhattan distance of closest intersection
    */
	public static int shortestManhattanDistance(String wirePathOne, String wirePathTwo) {
		int manhattanDistance = 0;
		
		List<Point> wireOneList = new ArrayList<>();
		List<Point> wireTwoList = new ArrayList<>();
		
		String[] wirePathOneArr = wirePathOne.split("\\,");
		String[] wirePathTwoArr = wirePathTwo.split("\\,");
		
		Point startPointX = new Point(0, 0);
		
		if(wirePathOneArr != null && wirePathOneArr.length > 0) {
			for(int i=0; i < wirePathOneArr.length; i++) {
				String move = wirePathOneArr[i];							//"R990","L7"
				if(!move.isEmpty() && move.length() > 1) {
					String direction = move.substring(0,1);					//"R","L","U","D"
					int numberOfSteps = Integer.parseInt(move.substring(1));
					int newX = startPointX.getX();
					int newY = startPointX.getY();
					switch(direction) {
					case "R":	//move to right
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX() + j, startPointX.getY());
							wireOneList.add(p);	
						}
						newX += numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					case "L":	//move to left
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX() - j, startPointX.getY());
							wireOneList.add(p);	
						}
						newX -= numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					case "U":	//move to up
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX(), startPointX.getY() + j);
							wireOneList.add(p);	
						}
						newY += numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					case "D":	//move to down
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX(), startPointX.getY() - j);
							wireOneList.add(p);	
						}
						newY -= numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					default:	//not valid input
						System.out.println("Input value" + move + " is not valid");
						break;
					}				
				}
			}
		}
				
		Point startPointY = new Point(0, 0);
		
		if(wirePathTwoArr != null && wirePathTwoArr.length > 0) {
			for(int i=0; i < wirePathTwoArr.length; i++) {
				String move = wirePathTwoArr[i];							//"R990","L7"
				if(!move.isEmpty() && move.length() > 1) {
					String direction = move.substring(0,1);					//"R","L","U","D"
					int numberOfSteps = Integer.parseInt(move.substring(1));
					int newX = startPointY.getX();
					int newY = startPointY.getY();
					switch(direction) {
					case "R":	//move to right
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX() + j, startPointY.getY());
							wireTwoList.add(p);	
						}
						newX += numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					case "L":	//move to left
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX() - j, startPointY.getY());
							wireTwoList.add(p);	
						}
						newX -= numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					case "U":	//move to up
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX(), startPointY.getY() + j);
							wireTwoList.add(p);	
						}
						newY += numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					case "D":	//move to down
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX(), startPointY.getY() - j);
							wireTwoList.add(p);	
						}
						newY -= numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					default:	//not valid input
						System.out.println("Input value" + move + " is not valid");
						break;
					}				
				}
			}
		}
		
		//calculate Manhattan Distance
		for(Point pOne : wireOneList) {
			for (Point pTwo : wireTwoList) {
				if(pOne.getX() == pTwo.getX() && pOne.getY() == pTwo.getY()) {
					int distance = Math.abs(pOne.getX()) + Math.abs(pOne.getY());	//Manhattan Distance
					if(manhattanDistance == 0) {
						manhattanDistance = distance;
					} else if(manhattanDistance > distance) {
						manhattanDistance = distance;
					}
				}
			}
		}
		
		return manhattanDistance;
	}
	
    /**
    * find all cross point and return the fewest steps to reach an intersection
    *
    * @param  wirePathOne   input of first wire
    * @param  wirePathTwo   input of second wire
    * @return Manhattan distance of closest intersection
    */
	public static int fewestStepsToIntersection(String wirePathOne, String wirePathTwo) {
		int sumOfSteps = 0;
		
		List<Point> wireOneList = new ArrayList<>();
		List<Point> wireTwoList = new ArrayList<>();
		List<Point> intersectionList = new ArrayList<>();
		List<Integer> stepsList = new ArrayList<>();
		
		String[] wirePathOneArr = wirePathOne.split("\\,");
		String[] wirePathTwoArr = wirePathTwo.split("\\,");
		
		Point startPointX = new Point(0, 0);
		
		if(wirePathOneArr != null && wirePathOneArr.length > 0) {
			for(int i=0; i < wirePathOneArr.length; i++) {
				String move = wirePathOneArr[i];							//"R990","L7"
				if(!move.isEmpty() && move.length() > 1) {
					String direction = move.substring(0,1);					//"R","L","U","D"
					int numberOfSteps = Integer.parseInt(move.substring(1));
					int newX = startPointX.getX();
					int newY = startPointX.getY();
					switch(direction) {
					case "R":	//move to right
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX() + j, startPointX.getY());
							wireOneList.add(p);	
						}
						newX += numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					case "L":	//move to left
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX() - j, startPointX.getY());
							wireOneList.add(p);	
						}
						newX -= numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					case "U":	//move to up
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX(), startPointX.getY() + j);
							wireOneList.add(p);	
						}
						newY += numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					case "D":	//move to down
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointX.getX(), startPointX.getY() - j);
							wireOneList.add(p);	
						}
						newY -= numberOfSteps;
						startPointX = new Point(newX, newY);
						break;
					default:	//not valid input
						System.out.println("Input value" + move + " is not valid");
						break;
					}				
				}
			}
		}
				
		Point startPointY = new Point(0, 0);
		
		if(wirePathTwoArr != null && wirePathTwoArr.length > 0) {
			for(int i=0; i < wirePathTwoArr.length; i++) {
				String move = wirePathTwoArr[i];							//"R990","L7"
				if(!move.isEmpty() && move.length() > 1) {
					String direction = move.substring(0,1);					//"R","L","U","D"
					int numberOfSteps = Integer.parseInt(move.substring(1));
					int newX = startPointY.getX();
					int newY = startPointY.getY();
					switch(direction) {
					case "R":	//move to right
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX() + j, startPointY.getY());
							wireTwoList.add(p);	
						}
						newX += numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					case "L":	//move to left
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX() - j, startPointY.getY());
							wireTwoList.add(p);	
						}
						newX -= numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					case "U":	//move to up
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX(), startPointY.getY() + j);
							wireTwoList.add(p);	
						}
						newY += numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					case "D":	//move to down
						for(int j=1; j <= numberOfSteps; j++) {
							Point p = new Point(startPointY.getX(), startPointY.getY() - j);
							wireTwoList.add(p);	
						}
						newY -= numberOfSteps;
						startPointY = new Point(newX, newY);
						break;
					default:	//not valid input
						System.out.println("Input value" + move + " is not valid");
						break;
					}				
				}
			}
		}
		
		for(Point pOne : wireOneList) {
			for(Point pTwo : wireTwoList) {
				if(pOne.getX() == pTwo.getX() && pOne.getY() == pTwo.getY()) {
					intersectionList.add(pOne);
				}
			}
		}
		
		//System.out.println("intersection points: ");
		for(Point p : intersectionList) {
			//System.out.println("Point (" + p.getX() + "," + p.getY() + ")");
			
			int stepsForWireOne = 0;
			int stepsForWireTwo = 0;
			
			for(int i=0; i < wireOneList.size(); i++) {
				Point pOne = wireOneList.get(i);
				if(pOne.getX() == p.getX() && pOne.getY() == p.getY()) {
					stepsForWireOne = i + 1;
					break;
				}
			}
			
			for(int i=0; i < wireTwoList.size(); i++) {
				Point pOne = wireTwoList.get(i);
				if(pOne.getX() == p.getX() && pOne.getY() == p.getY()) {
					stepsForWireTwo = i + 1;
					break;
				}
			}
			
			int totalSteps = stepsForWireOne + stepsForWireTwo;
			stepsList.add(totalSteps);
		}
		
		
		if(stepsList != null && stepsList.size() > 0) {
			Collections.sort(stepsList);
			sumOfSteps = stepsList.get(0);
		}
		
		/*
		//System.out.println(stepsList.get(0));
		for(Integer i : stepsList) {
			System.out.println(i.intValue());
		}		
		
		System.out.println("size: " + wireOneList.size());
		for(Point pOne : wireOneList) {
			System.out.println("Point (" + pOne.getX() + "," + pOne.getY() + ")");
		}
		
		System.out.println("size: " + wireTwoList.size());
		for (Point pTwo : wireTwoList) {
			System.out.println("Point (" + pTwo.getX() + "," + pTwo.getY() + ")");
		}
		*/

		
		return sumOfSteps;
	}
}
