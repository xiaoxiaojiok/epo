package common;
import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * @author: XiaoJian
 */
public class MongoDBTest {

    MongoClient mongo = null;

    public MongoDBTest(){
        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if(mongo != null){
            DB db = mongo.getDB("test");
            //authenticate the user
            System.out.println("auth user 'test/xiaojian'" +db.authenticate("test", "xiaojian".toCharArray()));
            //display all the dbs
            List<String> dbList = mongo.getDatabaseNames();
            System.out.println("-----------------show dbs--------------------");
            for(String dbName: dbList){
                System.out.println(dbName);
            }
            /**
             DB db = mongo.getDB("test");
             DBCollection table = db.getCollection("user");
             Display all collections from selected database.

             DB db = mongo.getDB("test");
             Set<String> tables = db.getCollectionNames();

             for(String coll : tables){
             System.out.println(coll);
             }
             */

        }
    }

    public void insert(){
        DB db = mongo.getDB("test");
        DBCollection table = db.getCollection("user");
        BasicDBObject document = new BasicDBObject();
        document.put("name", "John Nash");
        document.put("age", 26);
        document.put("createdDate", new Date());
        table.insert(document);
        System.out.println("insert successfully..." );
    }

    public void update(){
        DB db = mongo.getDB("test");
        DBCollection table = db.getCollection("user");

        BasicDBObject query = new BasicDBObject();
        query.put("name", "John Nash");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("name", "John Liu");

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);

        table.update(query, updateObj);
        System.out.println("update successfully..." );
    }

    public void query(){
        DB db = mongo.getDB("test");
        DBCollection table = db.getCollection("user");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John Liu");

        DBCursor cursor = table.find(searchQuery);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        System.out.println("query successfully..." );
    }

    public void remove(){
        DB db = mongo.getDB("test");
        DBCollection table = db.getCollection("user");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John Liu");

        table.remove(searchQuery);
        System.out.println("remove successfully..." );
    }
    public static void main(String []args){
    	MongoDBTest mongoDBClient = new MongoDBTest();
        mongoDBClient.insert();//insert one document to user table
        mongoDBClient.update();
        mongoDBClient.query();
       // mongoDBClient.remove();
    }
}
