package caralibro.model;

// Comments are attached to posts and can only contain text (No photos, videos, likes, etc).
// Can't be edited, only deleted if you have the right permissions.
// An example of some JSON responses made with user's 1443735325 session:
// - Get posts from page 326834508374 (source_ids): 
// Request: http://api.facebook.com/restserver.php?v=1.0&api_key=060c9d27db80e7bc1dab1f3ec1e48f63&ss=true&method=Stream.get&format=json&source_ids=326834508374&call_id=1267504281543&session_key=d10f11b7ad1fd8dc18857282-1443735325&sig=1678c2a39cd9055bcc806b0ab8b3be95
// Response: {"posts":[{"post_id":"326834508374_349385998374","viewer_id":1443735325,"source_id":326834508374,"type":56,"app_id":null,"attribution":null,"actor_id":100000751425511,"target_id":326834508374,"message":"Fan post!","attachment":{"description":""},"app_data":{},"action_links":null,"comments":{"can_remove":true,"can_post":true,"count":2,"comment_list":[{"fromid":100000751425511,"time":1267507442,"text":"Fan comment to fan post!","id":"326834508374_349385998374_14732243"},{"fromid":326834508374,"time":1267507466,"text":"Admin comment to fan post!","id":"326834508374_349385998374_14732258"}]},"likes":{"href":"http:\/\/www.facebook.com\/social_graph.php?node_id=349385998374&class=LikeManager","count":0,"sample":{},"friends":{},"user_likes":false,"can_like":true},"privacy":{"value":"NOT_EVERYONE"},"updated_time":1267507466,"created_time":1267507407,"tagged_ids":null,"is_hidden":false,"filter_key":"","permalink":"http:\/\/www.facebook.com\/pages\/testingAFanPage\/326834508374?v=feed&story_fbid=349385998374"},{"post_id":"326834508374_341543617371","viewer_id":1443735325,"source_id":326834508374,"type":46,"app_id":null,"attribution":null,"actor_id":326834508374,"target_id":null,"message":"Admin post!","attachment":{"description":""},"app_data":{},"action_links":null,"comments":{"can_remove":true,"can_post":true,"count":2,"comment_list":[{"fromid":100000751425511,"time":1267507429,"text":"Fan comment to admin post!","id":"326834508374_341543617371_11839285"},{"fromid":326834508374,"time":1267507474,"text":"Admin comment to admin post!","id":"326834508374_341543617371_11839310"}]},"likes":{"href":"http:\/\/www.facebook.com\/social_graph.php?node_id=341543617371&class=LikeManager","count":0,"sample":{},"friends":{},"user_likes":false,"can_like":true},"privacy":{"description":"Everyone","value":"EVERYONE","friends":"","networks":"","allow":"","deny":""},"updated_time":1267507474,"created_time":1267507389,"tagged_ids":null,"is_hidden":false,"filter_key":"","permalink":"http:\/\/www.facebook.com\/pages\/testingAFanPage\/326834508374?v=feed&story_fbid=341543617371"}],"profiles":[{"id":100000751425511,"url":"http:\/\/www.facebook.com\/profile.php?id=100000751425511","name":"Fede Testeando","pic_square":"http:\/\/static.ak.fbcdn.net\/pics\/q_silhouette.gif","type":"user"},{"id":326834508374,"url":"http:\/\/www.facebook.com\/pages\/testingAFanPage\/326834508374","name":"testingAFanPage","pic_square":"http:\/\/static.ak.fbcdn.net\/pics\/q_default.gif","type":"page"}],"albums":{}}
// - Get comments of post 326834508374_349385998374: 
// Request: http://api.facebook.com/restserver.php?v=1.0&api_key=060c9d27db80e7bc1dab1f3ec1e48f63&ss=true&method=Stream.getComments&format=json&post_id=326834508374_349385998374&call_id=1267504281952&session_key=d10f11b7ad1fd8dc18857282-1443735325&sig=f174f628c658dba5d0bcda6c1ae989bc
// Response: [{"fromid":100000751425511,"time":1267507442,"text":"Fan comment to fan post!","id":"326834508374_349385998374_14732243"},{"fromid":326834508374,"time":1267507466,"text":"Admin comment to fan post!","id":"326834508374_349385998374_14732258"}]
// - Remove post 326834508374_349385998374:
// Request: http://api.facebook.com/restserver.php?v=1.0&api_key=060c9d27db80e7bc1dab1f3ec1e48f63&ss=true&method=Stream.remove&format=json&post_id=326834508374_349385998374&call_id=1267504300894&session_key=d10f11b7ad1fd8dc18857282-1443735325&sig=ad325b68b4eadbd80e5088ee43664c38
// Response: true
public class Comment {
	// TODO: Find why it is not a Long instead of String!
	// It is composed of sourceId_postId_commentId
	private String id = null;
	private String text = null;
	private User user = null;
	// Comments can't be updated and only have a creation time.
	private Long time = null; // Unix time!

	public Comment() {
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}
	
}
