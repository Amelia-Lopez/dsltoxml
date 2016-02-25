Groovy DSL to XML Converter
===========================

This application automatically converts a DSL written in Groovy to an XML document.

Basic Example
=============

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

Complex Example
===============

Sample Input
------------
```
'e-mail' {
    from user
    to 'someone@somewhere.com'
    subject 'Orders'
    body (style: defaultStyle ? 'html' : bodyStyle) {
        p 'Attack at dawn.'
    }
}
```

With code bindings:
`[user: 'me@here.com', defaultStyle: true]`

Sample Output
-------------
```
<e-mail>
  <from>me@here.com</from>
  <to>someone@somewhere.com</to>
  <subject>Orders</subject>
  <body style='html'>
    <p>Attack at dawn.</p>
  </body>
</e-mail>
```