package autograph;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import autograph.exception.*;
/**
 * Edge contains all data for edge objects of a Graph.
 *
 * @author Keith Wentzel
 * @version 1.0
 */
public class Edge implements Serializable {

   /**
    * Direction - the various directions supported by the edge object
    */
   public enum Direction{
      NODIRECTION,
      STARTDIRECTION,
      ENDDIRECTION,
      DOUBLEDIRECTION
   };

   /**
    * EdgeStyle - the various styles supported by the edge object
    */
   public enum EdgeStyle{
      SOLID,
      DOTTED,
      DASHED
   };

   private String vId;
   private String vLabel;
   private Node vStartNode;
   private Node vEndNode;
   private Direction vDirection;
   private EdgeStyle vEdgeStyle;
   private int vStartX;
   private int vStartY;
   private int vEndX;
   private int vEndY;
   private Color vColor;
   
   private void mValidateEdge(String id, Node startNode, Node endNode) throws CannotAddEdgeException{
      if(id == null || id.isEmpty()){
         throw new CannotAddEdgeException("Edge must contain valid id.");
      }
      else if(startNode == null || endNode == null){
         throw new CannotAddEdgeException("Edge must have start and end node values.");
      }
   }

   /**
    * Edge Constructor - builds the edge object
    * @param id - variable name of the edge
    * @param label - label displayed for the edge
    * @param startNode - node at start of the edge
    * @param endNode - node at end of the edge
    * @param direction - direction of the edge
    * @param style - style of the edge
    * @see NodeStyle
    * @see Direction
    */
   public Edge(String id, String label, Node startNode, Node endNode,
           Direction direction, EdgeStyle style){
      try{
         mValidateEdge(id, startNode, endNode);
         vId = id;
         vLabel = label;
         vStartNode = startNode;
         vEndNode = endNode;
         vDirection = direction;
         vEdgeStyle = style;
         vColor = Color.black;
      }
      catch (CannotAddEdgeException e){
         //TODO: notify user of failure
      }
   }

   /**
    * GetName - used to access the variable name of the edge object to differentiate
    * from other edges
    * @return the variable name of the edge
    */
   public String mGetId(){
      return vId;
   }

   /**
    * SetLabel - changes the label of the edge
    * @param label - new label for the edge
    */
   public void mSetLabel(String label){
      vLabel = label;
   }

   /**
    * GetLabel - gets the label of the edge
    * @return the label of the edge
    */
   public String mGetLabel(){
      return vLabel;
   }

   /**
    * SetStartNode - sets the start node of the edge
    * @param start - the nodes the start of the edge is connected to
    * @see Node
    */
   public void mSetStartNode(Node start){
      vStartNode = start;
   }

   /**
    * GetStartNode - gets the start node of the edge
    * @return - the nodes the start of the edge is connected to
    * @see Node
    */
   public Node mGetStartNode(){
      return vStartNode;
   }

   /**
    * SetEndNode - sets the end node of the edge
    * @param end - the node the end of the edge is connected to
    * @see Node
    */
   public void mSetEndNode(Node end){
      vEndNode = end;
   }

   /**
    * GetEndNode - gets the end node of the edge
    * @return the node the end of the edge is connected to
    * @see Node
    */
   public Node mGetEndNode(){
      return vEndNode;
   }

   /**
    * SetDirection - sets the direction of the edge
    * @param dir - an enumeration of the direction of the edge
    * @see Direction
    */
   public void mSetDirection(Direction dir){
      vDirection = dir;
   }

   /**
    * GetDirection - gets the direction of the edge
    * @return - an enumeration of the direction of the edge
    * @see Direction
    */
   public Direction mGetDirection(){
      return vDirection;
   }

   /**
    * SetEdgeStyle - sets the edge's style
    * @param style - an enumeration of the edge style
    * @see EdgeStyle
    */
   public void mSetEdgeStyle(EdgeStyle style){
      vEdgeStyle = style;
   }

   /**
    * GetEdgeStyle - gets the edge's style
    * @return - an enumeration of the edge style
    * @see EdgeStyle
    */
   public EdgeStyle mGetEdgeStyle(){
      return vEdgeStyle;
   }
   
   /**
    * GetStartX - returns the x coordinate of the start position of the edge
    * @return vStartX
    */
   public int mGetStartX(){
      return vStartX;
   }
   
   /**
    * GetStartY - returns the y coordinate of the start position of the edge
    * @return vStartY
    */
   public int mGetStartY(){
      return vStartY;
   }
   
   /**
    * GetEndX - returns the x coordinate of the end position of the edge
    * @return vEndX
    */
   public int mGetEndX(){
      return vEndX;
   }
   
   /**
    * GetEndY - returns the y coordinate of the end position of the edge
    * @return - vEndY
    */
   public int mGetEndY(){
      return vEndY;
   }
   
   /**
    * SetStartCoordinates - sets the new start point of the edge
    * @param x - the x coordinate (in pixels) of the new start location.
    * @param y - the y coordinate (in pixels) of the new start location.
    */
   public void mSetStartCoordinates(int x, int y){
      vStartX = x;
      vStartY = y;
   }
   
   /**
    * SetEndCoordinates - sets the new end point of the edge
    * @param x - the x coordinate (in pixels) of the new end location.
    * @param y - the y coordinate (in pixels) of the new end location.
    */
   public void mSetEndCoordinates(int x, int y){
      vEndX = x;
      vEndY = y;
   }
   
   /**
    * GetColor - returns the color of the edge
    * @return - vColor
    */
   public Color mGetColor(){
      return vColor;
   }
   
   /**
    * SetColor - sets the color of the edge
    * @param color - the color to set the edge
    */
   public void mSetColor(Color color){
      vColor = color;
   }
   
   /**
    * DrawEdge - Draws an edge between two nodes. The edge will dynamically choose one of 4 points on each
    *            node as the start/end point
    * @param g - The graphics object to draw the edge for.
    */
   public void mDrawEdge(Graphics g){
      //TODO: implement for non-straight edges
      //TODO: implement for different endge styles/directions.
      //TODO: implement label placement.
      //TODO: figure out how we want to handle the case where the edge label is longer than the edge (if we need to recalculate node position etc.)
      
      g.setColor(this.mGetColor());
      
      int startX;
      int startY;
      int endX;
      int endY;
      int differenceX;
      int differenceY;
      
      Node startNode = this.mGetStartNode();
      Node endNode = this.mGetEndNode();
      
      int startNodeCenterX = startNode.mGetCenterX();
      int startNodeCenterY = startNode.mGetCenterY();
      int endNodeCenterX = endNode.mGetCenterX();
      int endNodeCenterY = endNode.mGetCenterY();
      
      if(startNodeCenterX - endNodeCenterX > 0){
         //we will either use the left, top, or bottom point
         differenceX = startNodeCenterX - endNodeCenterX;
         if(startNodeCenterY - endNodeCenterY > 0){
            //we will either user the left point or the top point
            differenceY = startNodeCenterY - endNodeCenterY;
            if(differenceX > differenceY){ //startNodeX > endNodeX && startNodeY > endNodeY && x difference is bigger.
               //use the left point on the start node and right point on the end node
               startX = startNodeCenterX - startNode.mGetWidth()/2;
               startY = startNodeCenterY;
               endX = endNodeCenterX + endNode.mGetWidth()/2;
               endY = endNodeCenterY;
            }
            else{ // startNodex > endNodeX && startNodeY > endNodeY && y difference is bigger
               //use the top point on the start node and bottom point on the end node
               startX = startNodeCenterX;
               startY = startNodeCenterY - startNode.mGetHeight()/2;
               endX = endNodeCenterX;
               endY = endNodeCenterY + endNode.mGetHeight()/2;
            }
         }
         else{ // startNodeX > endNodeX && endNodeY >= startNodeY
            //we will either use the left point or the bottom point
            differenceY = endNodeCenterY - startNodeCenterY;
            if (differenceX > differenceY){ //startNodeX > endNodeX && endNodeY >= startNodeY && differenceX > differenceY
               //use the left point on the start node and the right point on the end node
               startX = startNodeCenterX - startNode.mGetWidth()/2;
               startY = startNodeCenterY;
               endX =  endNodeCenterX + endNode.mGetWidth()/2;
               endY = endNodeCenterY;
            }
            else{
               //use the bottom point on the start node and the top point on the end node
               startX = startNodeCenterX;
               startY = startNodeCenterY + startNode.mGetHeight()/2;
               endX = endNodeCenterX;
               endY = endNodeCenterY - endNode.mGetHeight()/2;
            }
         }
      }
      else{
         //we will either use the right, top, or bottom point on the start node
         differenceX = endNodeCenterX - startNodeCenterX;
         if(startNodeCenterY - endNodeCenterY > 0){
            //use either right point or top point
            differenceY = startNodeCenterY - endNodeCenterY;
            if(differenceX > differenceY){
               //use the right point on the start node and the left point on the end node
               startX = startNodeCenterX + startNode.mGetWidth()/2;
               startY = startNodeCenterY;
               endX = endNodeCenterX - endNode.mGetWidth()/2;
               endY = endNodeCenterY;
            }
            else{
               //use the top point on the start node and the bottom point on the end node
               startX = startNodeCenterX;
               startY = startNodeCenterY - startNode.mGetHeight()/2;
               endX = endNodeCenterX;
               endY = endNodeCenterY + endNode.mGetWidth()/2;
            }
         }
         else{
            //use either right point or bottom point
            differenceY = endNodeCenterY - startNodeCenterY;
            if(differenceX > differenceY){
               //use right point on the start node and the left point on the end node
               startX = startNodeCenterX + startNode.mGetWidth()/2;
               startY = startNodeCenterY;
               endX = endNodeCenterX - endNode.mGetWidth()/2;
               endY = endNodeCenterY;
            }
            else{
               //use bottom point on the start node and the top point on the end node
               startX = startNodeCenterX;
               startY = startNodeCenterY + startNode.mGetHeight()/2;
               endX = endNodeCenterX;
               endY = endNodeCenterY - endNode.mGetHeight()/2;
            }
         }
      }
      
      
      g.drawLine(startX, startY, endX, endY);
   }
}
