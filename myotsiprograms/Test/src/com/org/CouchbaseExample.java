package com.org;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

public class CouchbaseExample 
{

	//Cluster cluster = CouchbaseCluster.create();
	public static void main(String arg[])
	{
	Cluster cluster = CouchbaseCluster.create("couchbase://52.172.27.78");
	Bucket bucket = cluster.openBucket();
	JsonObject user = JsonObject.empty()
		    .put("firstname", "Walter")
		    .put("lastname", "White")
		    .put("job", "chemistry teacher")
		    .put("age", 50);
	JsonDocument doc = JsonDocument.create("walter", user);
	JsonDocument response = bucket.upsert(doc);
	cluster.disconnect();
	}
	
}
