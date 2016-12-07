package helper;

import java.util.ArrayList;

import pacman.game.Constants.MOVE;

public class Node {
	boolean isLeafNode = false;
	MOVE myMove = MOVE.NEUTRAL;
	ArrayList<Node> childNodes = new ArrayList<Node>();

}
