Groovy DSL to XML Converter
===========================

This application automatically converts a DSL written in Groovy to an XML document.

Sample Input
------------
```
'e-mail' {
    from 'you@place.com'
    to 'someone@somewhere.com'
    subject 'Orders'
    body (style: 'html') {
        p 'Attack at dawn.'
    }
}
```

Sample Output
-------------
```
<e-mail>
  <from>you@place.com</from>
  <to>someone@somewhere.com</to>
  <subject>Orders</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
```