// Class representing a User in the social media system
class User {
    int userID;
    String name;
    int age;
    FriendNode friends;
    User next;

    User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

// Node representing a friend connection
class FriendNode {
    int friendID;
    FriendNode next;

    FriendNode(int friendID) {
        this.friendID = friendID;
        this.next = null;
    }
}

// Class to manage social media friend connections
class SocialMedia {
    private User head;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Add a friend connection between two users
    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friends = addToFriendList(user1.friends, userID2);
        user2.friends = addToFriendList(user2.friends, userID1);
    }

    private FriendNode addToFriendList(FriendNode head, int friendID) {
        FriendNode newFriend = new FriendNode(friendID);
        newFriend.next = head;
        return newFriend;
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friends = removeFromFriendList(user1.friends, userID2);
        user2.friends = removeFromFriendList(user2.friends, userID1);
    }

    private FriendNode removeFromFriendList(FriendNode head, int friendID) {
        if (head == null) return null;
        if (head.friendID == friendID) return head.next;

        FriendNode temp = head;
        while (temp.next != null && temp.next.friendID != friendID) {
            temp = temp.next;
        }

        if (temp.next != null) temp.next = temp.next.next;
        return head;
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual Friends:");
        FriendNode temp1 = user1.friends;
        while (temp1 != null) {
            FriendNode temp2 = user2.friends;
            while (temp2 != null) {
                if (temp1.friendID == temp2.friendID) {
                    System.out.println("User ID: " + temp1.friendID);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of User " + userID + ":");
        FriendNode temp = user.friends;
        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendID);
            temp = temp.next;
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID=" + temp.userID + ", Name=" + temp.name + ", Age=" + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode friendTemp = temp.friends;
            while (friendTemp != null) {
                count++;
                friendTemp = friendTemp.next;
            }
            System.out.println("User ID " + temp.userID + " has " + count + " friends.");
            temp = temp.next;
        }
    }

    // Find a user by ID
    private User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Display all users
    public void displayUsers() {
        User temp = head;
        System.out.println("Users:");
        while (temp != null) {
            System.out.println("ID=" + temp.userID + ", Name=" + temp.name + ", Age=" + temp.age);
            temp = temp.next;
        }
    }
}

// Main class to test social media operations
public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);

        sm.searchUser("Alice", -1);

        sm.countFriends();

        sm.displayUsers();
    }
}
