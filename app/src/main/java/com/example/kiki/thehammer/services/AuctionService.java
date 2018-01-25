package com.example.kiki.thehammer.services;

import com.example.kiki.thehammer.helpers.DateHelper;
import com.example.kiki.thehammer.helpers.DummyData;
import com.example.kiki.thehammer.model.Auction;
import com.example.kiki.thehammer.model.Item;
import com.example.kiki.thehammer.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.List;

/**
 * Created by Lazar on 22/1/2018.
 */

public class AuctionService {

    private static final String AUCTIONS_REFERENCE = "auctions";
    public static final Query ALL_AUCTIONS_QUERY = FirebaseDatabase.getInstance().getReference(AUCTIONS_REFERENCE);
    private DatabaseReference dbReference;

    public AuctionService(){
        this.dbReference = FirebaseDatabase.getInstance().getReference(AUCTIONS_REFERENCE);
    }

    public void addAuctions(List<Auction> auctions, List<User> users, List<Item> items) {
        for(int i = 0; i < 10; i++){
            String id = dbReference.push().getKey();
            Auction auction = new Auction(id, DummyData.auction_default_start_price, DummyData.default_auction_start_date_str,
                    DummyData.default_auction_end_date_str, new User(users.get(i).getId()), new Item(items.get(i).getId()));

            dbReference.child(id).setValue(auction);

            auctions.add(auction);
        }
    }

    public Query getAuctionById(String auction_id){
        return dbReference.child(auction_id);
    }
}
