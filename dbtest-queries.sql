SELECT sum(claimed_charge) AS "Total Claimed Charge" 
FROM   document 
WHERE  status = "exported"; 


SELECT insured_name    AS "Insured Name", 
       insured_address AS "Insured Address", 
       claimed_charge  AS "Claimed Charge" 
FROM   document AS d 
       JOIN batch AS b 
         ON d.batch_id = b.id 
WHERE  d.status = "to_reprice" 
       AND b.customer_id IN ( 1, 2 ); 
